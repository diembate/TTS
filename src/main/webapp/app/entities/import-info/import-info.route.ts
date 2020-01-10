import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IImportInfo, ImportInfo } from 'app/shared/model/import-info.model';
import { ImportInfoService } from './import-info.service';
import { ImportInfoComponent } from './import-info.component';
import { ImportInfoDetailComponent } from './import-info-detail.component';
import { ImportInfoUpdateComponent } from './import-info-update.component';

@Injectable({ providedIn: 'root' })
export class ImportInfoResolve implements Resolve<IImportInfo> {
  constructor(private service: ImportInfoService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IImportInfo> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((importInfo: HttpResponse<ImportInfo>) => {
          if (importInfo.body) {
            return of(importInfo.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ImportInfo());
  }
}

export const importInfoRoute: Routes = [
  {
    path: '',
    component: ImportInfoComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'warehouseApp.importInfo.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ImportInfoDetailComponent,
    resolve: {
      importInfo: ImportInfoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'warehouseApp.importInfo.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ImportInfoUpdateComponent,
    resolve: {
      importInfo: ImportInfoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'warehouseApp.importInfo.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ImportInfoUpdateComponent,
    resolve: {
      importInfo: ImportInfoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'warehouseApp.importInfo.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

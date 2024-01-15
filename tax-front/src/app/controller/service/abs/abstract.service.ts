import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthService} from "../../../core/auth/auth.service";
import {Pageable} from "../../dto/Pageable";
import {Criteria} from "../../dto/Criteria.model";
import {environment} from "../../../../environments/environment";

@Injectable({
    providedIn: 'root'
})
export abstract class AbstractService<T> {
    protected API = environment.URL;
    private _list: Array<T> = new Array<T>()

    protected constructor(API: string, public authService: AuthService,
                          public http: HttpClient) {
        this.API += API;
    }


    get list(): Array<T> {
        return this._list;
    }

    set list(value: Array<T>) {
        this._list = value;
    }

    create(d: T): Observable<T> {
        return this.http.post<T>(this.API + 'save', d);
    }

    update(d: T): Observable<T> {
        return this.http.put<T>(this.API + 'update', d);
    }


    delete_by_id(id: number): Observable<T> {
        return this.http.delete<T>(this.API + `id/${id}`);
    }

    getById(id: any): Observable<T> {
        return this.http.get<T>(this.API + `id/${id}`);
    }


    findAll(pageable: Pageable): Observable<Criteria<T>> {
        return this.http.get<Criteria<T>>(this.API + `page`, {
            params: {
                'page': pageable.page,
                'size': pageable.size
            }
        });
    }

    getAll() {
        this.http.get<Array<T>>(this.API + `all`).subscribe(res => {
            this.list = res
        })
    }


}

import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/auth/auth.service";
import {AbstractService} from "./abs/abstract.service";
import {Terrain} from "../model/terrain.model";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class TerrainService extends AbstractService<Terrain> {

    constructor(public http: HttpClient,
                private auth: AuthService) {
        super('terrain/', auth, http);
    }

    public find_by_redevable(cin): Observable<Terrain[]> {
        return this.http.get<Terrain[]>(this.API + `redevable/cin/${cin}`)
    }

}

import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/auth/auth.service";
import {AbstractService} from "./abs/abstract.service";
import {Terrain} from "../model/terrain.model";

@Injectable({
    providedIn: 'root'
})
export class TerrainService extends AbstractService<Terrain> {

    constructor(public http: HttpClient,
                private auth: AuthService) {
        super('terrain/', auth, http);
    }

}

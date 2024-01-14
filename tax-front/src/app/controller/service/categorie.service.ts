import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/auth/auth.service";
import {AbstractService} from "./abs/abstract.service";
import {Categorie} from "../model/categorie.model";

@Injectable({
    providedIn: 'root'
})
export class CategorieService extends AbstractService<Categorie> {

    constructor(public http: HttpClient,
                private auth: AuthService) {
        super('categorie/', auth, http);
    }

}

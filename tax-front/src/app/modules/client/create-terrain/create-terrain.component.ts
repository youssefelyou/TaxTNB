import {Component} from '@angular/core';
import {MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {Terrain} from "../../../controller/model/terrain.model";
import {TerrainService} from "../../../controller/service/terrain.service";
import {AuthService} from "../../../core/auth/auth.service";
import {Categorie} from "../../../controller/model/categorie.model";
import {CategorieService} from "../../../controller/service/categorie.service";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {NgForOf} from "@angular/common";

@Component({
    selector: 'app-create-terrain',
    templateUrl: './create-terrain.component.html',
    imports: [
        MatDialogModule,
        MatButtonModule,
        MatFormFieldModule,
        FormsModule,
        MatInputModule,
        MatOptionModule,
        MatSelectModule,
        NgForOf
    ],
    standalone: true
})
export class CreateTerrainComponent {
    terrain: Terrain = new Terrain()

    constructor(private service: TerrainService,
                private _matDialogRef: MatDialogRef<CreateTerrainComponent>,
                private catService: CategorieService,
                private auth: AuthService) {
        console.log(this.auth._user)
    }

    get categories(): Array<Categorie> {
        return this.catService.list;
    }


    save() {
        this.terrain.redevable.id = this.auth._user.id
        this.terrain.redevable.nom = this.auth._user.lastName
        this.terrain.redevable.prenom = this.auth._user.firstName
        this.service.create(this.terrain)
            .subscribe(res => {
                console.log(res)
                this._matDialogRef.close('success')
            }, error => {
                console.error(error)
            })
    }
}

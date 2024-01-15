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
    selector: 'app-create-categorie',
    templateUrl: './category.html',
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
export class CategoryComponent {
    categorie: Categorie = new Categorie()

    constructor(private service: TerrainService,
                private _matDialogRef: MatDialogRef<CategoryComponent>,
                private catService: CategorieService,
                private auth: AuthService) {
    }

    set categories(value: Array<Categorie>) {
        this.catService.list = value;
    }

    get categories(): Array<Categorie> {
        return this.catService.list;
    }


    save() {
        this.catService.create(this.categorie)
            .subscribe(res => {
                this.categories.push({...res})
            })
    }
}

import {Component, OnInit} from '@angular/core';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatButtonModule} from "@angular/material/button";
import {FuseCardComponent} from "../../../../@fuse/components/card";
import {MatIconModule} from "@angular/material/icon";
import {RouterLink} from "@angular/router";
import {CreateTerrainComponent} from "../create-terrain/create-terrain.component";
import {TerrainService} from "../../../controller/service/terrain.service";
import {MatDialog} from "@angular/material/dialog";
import {Terrain} from "../../../controller/model/terrain.model";
import {Pageable} from "../../../controller/dto/Pageable";
import {Categorie} from "../../../controller/model/categorie.model";
import {CategorieService} from "../../../controller/service/categorie.service";
import {NgForOf, NgIf} from "@angular/common";
import {CategoryComponent} from "../category/category";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    imports: [
        MatInputModule,
        MatSelectModule,
        MatButtonModule,
        FuseCardComponent,
        MatIconModule,
        RouterLink,
        NgForOf,
        NgIf
    ],
    standalone: true
})
export class HomeComponent implements OnInit {
    terrains: Array<Terrain>
    page: Pageable = new Pageable(0, 2)

    constructor(public dialog: MatDialog,
                private catService: CategorieService,
                private service: TerrainService) {
    }

    get categories(): Array<Categorie> {
        return this.catService.list;
    }

    set categories(value: Array<Categorie>) {
        this.catService.list = value;
    }

    openCreate() {
        const dialogRef = this.dialog.open(CreateTerrainComponent);
        dialogRef.afterClosed().subscribe(result => {
            if (result === 'success') {
                this.fetch_data()
            }
        });
    }

    openCreateCategory() {
        const dialogRef = this.dialog.open(CategoryComponent);
        dialogRef.afterClosed().subscribe(result => {
            if (result === 'success') {
                this.fetch_data()
            }
        });
    }

    ngOnInit() {
        this.catService.getAll()
        this.fetch_data();
    }

    private fetch_data() {
        this.service.find_by_redevable(this.catService.authService._user.id).subscribe(res => {
            this.terrains = res
            console.log(res)
        })
    }
}

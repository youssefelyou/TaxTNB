import {Routes} from '@angular/router';
import {ExampleComponent} from 'app/modules/admin/example/example.component';
import {HomeComponent} from "./home/home.component";
import {CategoryComponent} from "./category/category";

export default [
    {
        path: 'home',
        component: HomeComponent,
    },
    {
        path: 'category',
        component: CategoryComponent,
    },
] as Routes;

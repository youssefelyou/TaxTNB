import {Routes} from '@angular/router';
import {ExampleComponent} from 'app/modules/admin/example/example.component';
import {HomeComponent} from "./home/home.component";

export default [
    {
        path: 'home',
        component: HomeComponent,
    },
] as Routes;

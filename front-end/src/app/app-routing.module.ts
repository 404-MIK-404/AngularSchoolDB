import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppComponent} from "./app.component";
import {SignUpFormComponent} from "../presentation/sign-up-form/sign-up-form.component";
import {WebSiteComponent} from "../presentation/web-site/web-site.component";

const routes: Routes = [
  {path: "", component: WebSiteComponent},
  {path: "hi",component: SignUpFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignUpFormComponent } from './sign-up-form/sign-up-form.component';
import { WebSiteComponent } from './web-site/web-site.component';



@NgModule({
  declarations: [
    SignUpFormComponent,
    WebSiteComponent
  ],
  exports: [
    WebSiteComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PresentationModule { }

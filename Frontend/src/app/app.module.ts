import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { SearchComponent } from './search/search.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { HeadingComponent } from './heading/heading.component';
import { SearchService } from './search/search.service';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { BookReviewFormComponent } from './book-review-form/book-review-form.component';
import { BookInfoDialogComponent } from './book-info-dialog/book-info-dialog.component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LoginService } from './login/login.service';
import { UserListComponent } from './user-list/user-list.component';
import { ToppyModule } from 'toppy';
import { WelcomeSpeechComponent } from './virtual-assistant/welcome-speech/welcome-speech.component'
import { TagListComponent } from './tag-list/tag-list.component';
import { BookRecommendComponent } from './book-recommend/book-recommend.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { YesNoPipe } from './yes-no.pipe';
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';
import { BookOrderDialogComponent } from './book-order-dialog/book-order-dialog.component';
import { TemplateCategoryComponent } from './template-category/template-category.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    WelcomeComponent,
    HeadingComponent,
    LoginComponent,
    RegistrationComponent,
    BookReviewFormComponent,
    BookInfoDialogComponent,
    UserListComponent,
    WelcomeSpeechComponent,
    TagListComponent,
    BookRecommendComponent,
    WishlistComponent,
    UserProfileComponent,
    YesNoPipe,
    WelcomeAdminComponent,
    BookOrderDialogComponent,
    TemplateCategoryComponent
    ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatDialogModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ToppyModule,
    RouterModule.forRoot([
      { path: 'search', component: SearchComponent},
      { path: 'login', component: LoginComponent},
      { path: 'registration', component: RegistrationComponent},
      { path: 'review', component: BookReviewFormComponent},
      { path: 'welcome', component: WelcomeComponent},
      {path: 'recommend',component: BookRecommendComponent},
      { path: 'profile', component: UserProfileComponent},
      { path: 'userList', component: UserListComponent },
      { path: 'tagList', component: TagListComponent },
      { path: 'employee', component: WelcomeAdminComponent },
      { path: 'category', component: TemplateCategoryComponent },
      { path: '', redirectTo:'welcome', pathMatch: 'full' },
      { path: '**', redirectTo:'welcome', pathMatch: 'full' }
    ])
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  providers:
  [BookInfoDialogComponent,
  LoginService],
  bootstrap: [AppComponent],
  exports:[WelcomeSpeechComponent],
  entryComponents:[BookInfoDialogComponent]
})
export class AppModule { }

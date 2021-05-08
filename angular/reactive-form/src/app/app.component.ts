import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { PasswordValidator } from './shared/confirm-password.validator';
import { forbiddenNameValidator } from './shared/user-name.validator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  registrationForm;

  ngOnInit() {
    this.registrationForm = this.fb.group({
      //userName : ['Akash',[Validators.required,Validators.minLength(3), forbiddenNameValidator]],
      userName: ['Ahsh', [Validators.required, Validators.minLength(3), forbiddenNameValidator(/password/)]],
      password: [''],
      confirmPassword: [''],
      email: [''],
      subscribe: [false],
      address: this.fb.group({
        state: 'state',
        city: 'city'
      }),
      alternateEmails: this.fb.array([])
    }, { validators: PasswordValidator });

    this.registrationForm.get('subscribe').valueChanges
      .subscribe(checkedValue => {
        const email = this.registrationForm.get('email');
        if (checkedValue) {
          email.setValidators(Validators.required);
        } else {
          email.clearValidators();
        }
        email.updateValueAndValidity();
      });

  }

  get userName() {
    return this.registrationForm.get('userName');
  }

  get email() {
    return this.registrationForm.get('email');
  }

  get alternateEmails() {
    return this.registrationForm.get('alternateEmails') as FormArray;
  }

  addAlternateEmail() {
    this.alternateEmails.push(this.fb.control(''));
  }


  onSubmit() {
    console.log(this.registrationForm.value);

  }
  //  registrationForm :FormGroup = new FormGroup({
  //   userName : new FormControl('Akash'),
  //   password : new FormControl(''),
  //   confirmPassword : new FormControl(''),
  //   address: new FormGroup({
  //     state :new FormControl('India'),
  //     city :new FormControl('Kolkata'),
  //   })

  // });
}

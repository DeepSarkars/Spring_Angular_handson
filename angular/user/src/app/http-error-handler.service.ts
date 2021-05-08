import { Injectable } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

import { Observable, of } from 'rxjs';



/** Type of the handleError function returned by HttpErrorHandler.createHandleError */
export type HandleError =
    <T> (operation?: string, result?: T) => (error: HttpErrorResponse) => Observable<T>;

/** Handles HttpClient errors */
@Injectable({
    providedIn: 'root'
})
export class HttpErrorHandler {
    constructor() { }

    createHandleError = (serviceName = '') => {
        return <T>(operation = 'operation', result = {} as T) =>
            this.handleError(serviceName, operation, result);
    }

    handleError<T>(serviceName = '', operation = 'operation', result = {} as T) {

        return (error: HttpErrorResponse): Observable<T> => {
            console.error(error); 
            return of(result);
        };

    }
}
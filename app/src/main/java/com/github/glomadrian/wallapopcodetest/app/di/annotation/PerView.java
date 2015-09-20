package com.github.glomadrian.wallapopcodetest.app.di.annotation;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom annotation for use with Views
 *
 * @author Adrián García Lomas
 */
@Scope @Retention(RUNTIME) public @interface PerView {
}

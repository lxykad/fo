package com.jitu.buddha.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lxy
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {

}

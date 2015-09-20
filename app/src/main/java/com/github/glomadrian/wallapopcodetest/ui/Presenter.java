package com.github.glomadrian.wallapopcodetest.ui;

/**
 * All Presenters extends this Abstract Presenter and below to a view
 * In the presenter the view life cycle are mapped because it needs to know the view state
 * to perform actions
 * The methods are not abstract because is not necessary to implements all life cycle
 *
 * @author Adrián García Lomas
 */
public abstract class Presenter<T extends View> {

  protected T view;

  public void onCreate() {
    //Empty
  }

  public void onResume() {
    //Empty
  }

  public void onPause() {
    //Empty
  }

  public void onDestroy() {
    //Empty
  }

  /**
   * The onViewReady method is used when the layout has been inflated and the view
   * is fully ready
   */
  public void onViewReady() {
    //Empty
  }

  /**
   * The view must be attached to the presenter in order to work
   */
  public void attachView(T view) {
    this.view = view;
  }
}

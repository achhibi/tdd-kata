package org.amch.tdd.exception;

public class UnexpectedLetter extends Exception{
  public UnexpectedLetter() {
    super("The letter provided is invalid.");
  }
}
package com.ias.animals.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
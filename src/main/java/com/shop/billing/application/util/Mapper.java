package com.shop.billing.application.util;

public interface Mapper {
    <T> T convert(Object o, Class<T> destinationClass);
}

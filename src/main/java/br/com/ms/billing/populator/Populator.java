package br.com.ms.billing.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source,TARGET target);
}

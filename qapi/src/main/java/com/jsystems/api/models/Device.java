package com.jsystems.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;

    @JsonProperty(value = "device.model", required = true)
    public List<Comp> deviceModel;
}

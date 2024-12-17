package com.amitph.java.io.download.file.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    List<Object> results = new ArrayList<>();
    Info info;
}

@Getter
@Setter
@ToString
class Info {
    private String seed;
    private float results;
    private float page;
    private String version;
}

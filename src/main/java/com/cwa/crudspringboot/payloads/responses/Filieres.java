package com.cwa.crudspringboot.payloads.responses;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filieres {
    private List<FiliereRecord> datas;
}

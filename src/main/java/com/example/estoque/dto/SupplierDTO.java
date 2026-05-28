package com.example.estoque.dto;

import com.example.estoque.model.document.Supplier;
import lombok.*;

@Builder //cria um construtor com o padrão de projeto Builder automaticamente
@AllArgsConstructor //cria um construtor com todos os argumentos automaticamente
@NoArgsConstructor //cria um construtor sem argumentos automaticamente
@Setter //cria os métodos set automaticamente
@Getter
public class SupplierDTO {

    private String id;
    private String name;
    private String email;
    private  String phone;
    private  String cnpj;

    public static SupplierDTO fromSupplier(Supplier supplier)  {
        return SupplierDTO.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .cnpj(supplier.getCnpj())
                .build();
    }
}

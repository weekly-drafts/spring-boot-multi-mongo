package com.marcosbarbero.wd.multiplemongo.repository.secondary;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marcos Barbero
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "second_mongo")
public class SecondaryModel {

    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "SecondaryModel{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}

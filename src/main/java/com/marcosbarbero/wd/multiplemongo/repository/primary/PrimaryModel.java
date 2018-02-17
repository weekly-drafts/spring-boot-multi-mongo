package com.marcosbarbero.wd.multiplemongo.repository.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Marcos Barbero
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "first_mongo")
public class PrimaryModel {

	@Id
	private String id;

	private String value;

	@Override
	public String toString() {
        return "PrimaryModel{" + "id='" + id + '\'' + ", value='" + value + '\''
				+ '}';
	}
}

package io.efficientsoftware.simplebookscli.repository;

import org.springframework.stereotype.Service;

import io.efficientsoftware.simplebookscli.model.Business;
import lombok.Data;

@Service
@Data
public class DataCache {

	private Business business;

}

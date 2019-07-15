package com.nice.elsa.elsifyer.impl.service;

import com.nice.elsa.elsifyer.rest.ElsaRequest;
import com.nice.elsa.elsifyer.rest.ElsaResponse;
import org.springframework.stereotype.Service;

public interface ElsaService {

    ElsaResponse elsify(ElsaRequest request);
}

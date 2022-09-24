package contracts.account

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should find car by id"
    request {
        method GET()
        url('/cars/12345')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("findCarResponse.json"))
    }
}
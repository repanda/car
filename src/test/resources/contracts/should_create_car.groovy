package contracts.account

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create car"
    request {
        method POST()
        url('/cars')
        body(
                brand: 'Flexa',
                licensePlate: 'L-CS8877E',
                status: 'AVAILABLE',
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
    }
}
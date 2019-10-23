
CREATE TABLE fund_request (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT NOT NULL,
    fund_needed DOUBLE NOT NULL,
    requested_by INT NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (category_id),
    active BOOLEAN NOT NULL DEFAULT 1,
    CHECK (fund_needed > 0)
    
);


CREATE TABLE requestor_transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id VARCHAR(50) NOT NULL,
    fund_needed DOUBLE NOT NULL,
    status VARCHAR(100) NOT NULL DEFAULT 'VERIFIED',
    requested_by INT NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL DEFAULT 1,
    UNIQUE (category_id),
    CHECK (fund_needed > 0)
);
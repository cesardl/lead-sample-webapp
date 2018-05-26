package com.javachap.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Base Domain Object
 *
 * @author Varma
 */
public interface Domain extends Serializable {

    Long getId();

    void setId(Long id);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Date getModifiedDate();

    void setModifiedDate(Date modifiedDate);
}

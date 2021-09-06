package ry.rudenko.yevhenii.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token implements IBooksAuthors{

    private String id;
    private String userId;
    private String token;
}

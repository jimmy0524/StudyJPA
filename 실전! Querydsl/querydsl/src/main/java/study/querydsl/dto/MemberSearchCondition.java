package study.querydsl.dto;

import lombok.Data;

//검색 조건
@Data
public class MemberSearchCondition {

    private String username;
    private String teamName;
    private Integer ageGoe;
    private Integer ageLoe;
}

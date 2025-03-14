package study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private String name;
    private int age;

    @QueryProjection
    public MemberDto(String username, int age) {
        this.name = username;
        this.age = age;
    }
}

package com.hk2.dap.domain.user.entity;

import com.hk2.dap.domain.lesson.entity.LessonStudent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String  userId;

    @Column
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false)
    private String phoneNum;

    @ManyToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<LessonStudent> lessonList;

    @Builder
    public User(Long id, String userId, String userPassword, String userName, String nickName, UserType userType, String phoneNum) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.nickName = nickName;
        this.userType = userType;
        this.phoneNum = phoneNum;
    }
}

package com.ttinder.ttinder.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberInfo is a Querydsl query type for MemberInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberInfo extends EntityPathBase<MemberInfo> {

    private static final long serialVersionUID = -1545444350L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberInfo memberInfo = new QMemberInfo("memberInfo");

    public final QTimeStamped _super = new QTimeStamped(this);

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath info = createBoolean("info");

    public final StringPath introduce = createString("introduce");

    public final StringPath location = createString("location");

    public final BooleanPath logging = createBoolean("logging");

    public final StringPath mbti = createString("mbti");

    public final QMember member;

    public final NumberPath<Integer> messageNum = createNumber("messageNum", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath photo = createString("photo");

    public final StringPath userName = createString("userName");

    public QMemberInfo(String variable) {
        this(MemberInfo.class, forVariable(variable), INITS);
    }

    public QMemberInfo(Path<? extends MemberInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberInfo(PathMetadata metadata, PathInits inits) {
        this(MemberInfo.class, metadata, inits);
    }

    public QMemberInfo(Class<? extends MemberInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}


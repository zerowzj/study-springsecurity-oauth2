package study.springboot.security.oauth2.auth.server.dao.accesstoken;

public interface AccessTokenDao {

    int insert(AccessTokenEO entity);

    int update(AccessTokenEO entity);
}

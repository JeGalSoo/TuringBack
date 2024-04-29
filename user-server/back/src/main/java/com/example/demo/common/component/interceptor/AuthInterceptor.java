package com.example.demo.common.component.interceptor;

import com.example.demo.common.component.security.JwtProvider;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.SecretKey;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwt;
    private final UserRepository re;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = jwt.extractTokenFromHeader(request);
//        if (ObjectUtils.isEmpty(token)){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        String strId = jwt.getPayload(token);
//        Long id = Long.parseLong(strId);
//
//        Optional<User> user = Optional.of(re.findById(id).get());
//
//        if(ObjectUtils.isEmpty(user)){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        String token = jwt.extractTokenFromHeader(request);
//        log.info("1-인터셉터 토큰 로그 bearer 포함 : ***********************************" + token);
//        if (token.equals("undefined")) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        Long id = jwt.getPayload(token).get("userId", Long.class); //Long.class는 디스크 정적 클래스를 나타냄(깅력한타입)
//        log.info("2- 인터셉터 사용자 id : {}", id);
//
//        Optional<User> user = re.findById(id);
//        log.info("3- 인터셉터 사용자 정보 : {}", user);
//        if (!user.isPresent()) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//            return false;
//        }
//        log.info("4- 인터셉터 최종 여부 : {}", true);
        return Stream.of(request)
                .map(i->jwt.extractTokenFromHeader(i))
                .filter(i->!i.equals("undefined"))
                .map(i->jwt.getPayload(i).get("id",Long.class))
                .map(i->re.findById(i))
                .filter(i->i.isPresent())
                .findFirst()
                .isPresent();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

---
# theming
theme: './'
title: '2 Stack zabmantle'
titleTemplate: '%s - zabmantle'
colorSchema: 'light'
highlighter: 'shiki'
fonts:
  sans: 'Poor Story'
  serif: 'Noto Sans KR'
  mono: 'JetBrains Mono'
defaults:
  layout: 'centre'

# 1 Page
layout: 'cover'
---
# ~~풀스택~~ 둘스택 짭맨틀
두근두근 라이브 코딩


---
# 2 Page
layout: 'image-right'
image: 'https://source.unsplash.com/user/greennlab/likes'
---
# .editorconfig
일관된 코드 작성 규칙을 정의해요.
```
root = true

[*]
charset = utf-8
indent_size = 2
indent_style = space
insert_final_newline = true
max_line_length = 128
trim_trailing_whitespace = true
ij_any_variable_annotation_wrap = split_into_lines
ij_any_field_annotation_wrap = split_into_lines
ij_any_keep_line_breaks = true

[*.java]
indent_size = 4

[{*.html,*.jsp}]
max_line_length = off

[*.md]
trim_trailing_whitespace = false
```

---
# 3 Page
layout: 'image-right'
image: 'https://source.unsplash.com/user/greennlab/likes'
---
# build.gradle
테스트 커버리지를 위해서 `jacoco`를 설정해요.

```groovy {3|8}
plugins {
    // ...
    id 'jacoco'
}

tasks.named('test') {
    useJUnitPlatform()
    finalizedBy(jacocoTestReport)
}

```

---
# 4 Page
layout: 'image-small-right'
image: 'https://source.unsplash.com/user/greennlab/likes'
---
# build.gradle
`jacoco` 실행 결과를 리포팅하는 설정이에요.
```groovy {all|4-7|13}
jacocoTestReport {
    afterEvaluate {
        classDirectories.setFrom(files(classDirectories.files.collect {
            fileTree(dir: it, excludes: [
                    "**/*Application.class",
                    "**/*WebClient.class",
                    "**/config/*"
            ])
        })
        )
    }

    finalizedBy(jacocoTestCoverageVerification)
}
```

<v-click>
<img class="image01">
</v-click>
<v-click>
<img class="image02">
</v-click>


---
# 5 Page
layout: 'image-right'
image: 'https://source.unsplash.com/user/greennlab/likes'
---
# build.gradle
테스트 커버리지를 측정하는 규칙을 정의해요.
```groovy {all|6|9-11}
jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = 'CLASS'
            limit {
                minimum = 0.99
            }
            excludes = [
                    "*.*Application",
                    "*.*WebClient",
                    "*.config.*"
            ]
        }
    }
}
```


---
# 6 Page
layout: 'default'
---
# target
꼬멘틀 이라고 하는 단어 맞추기 게임

## 살펴보기
1. 단어 입력하면 어떻게 될까?
2. 단어 전송 이후에 결과값은 어떨까? 

<div class="image03"></div>


---
# 7 Page
layout: 'default'
---
# 개발자도구 활용하기
`Network`탭에서 보면,  

<div class="image04"></div>


---
# 8 Page
layout: 'default'
---
# 개발자도구 활용하기
`Source`탭에서 보면,  

<div class="image05"></div>


---
# 9 Page
layout: 'default'
---
# [Spring Initializr](https://start.spring.io/)

<br><br>

추가할 dependencies 는,
### 🌱`Spring Reactive Web`
### 🌶`lombok️`


---
# 10 Page
layout: 'default'
---
# git branch 전략
<iframe width="100%" height="90%" src="https://www.youtube.com/embed/Lp9q2saJMDk" title="YouTube video player" frameborder="0" 
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>



---
# 11 Page
layout: 'default'
---
# Servlet Container
## 기본은 *Netty*

> 팀장님께서 *Undertow*로 바꿔보자고 하셔서....


**`build.gradle`**
```groovy{2}
dependencies {
  implementation 'org.springframework.boot:spring-boot-starter-webflux'

  // ...
}
```


---
# 12 Page
layout: 'default'
---
# Servlet Container
## *Undertow*로 바꾸기
```groovy{2-5}
dependencies {
	implementation ('org.springframework.boot:spring-boot-starter-webflux') {
    exclude group: 'org.springframework.boot', module: 'spring-boot-starter-netty'
  }
  implementation 'org.springframework.boot:spring-boot-starter-undertow'

  // ...
}
```

> 기본 내장된 `Netty` 와 성능에 대한 비교는 "초콜렛 vs 바닐라" 같은 식이라서 불가하다고 하네요.  
> 하지만, `Undertow`는 Servlet Spec 을 준수하는데 초점이 맞춰져 있고, `Netty`를 엔진으로 쓰고 있다고 해요.  
> ~~Netty를 만든게 한국인이라서 더 좋음~~

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
drawings: 
  enabled: false

# 0 Page
layout: 'cover'
---
# ~~풀스택~~ 둘스택 짭맨틀
두근두근 라이브 코딩


---
# 1 Page
layout: 'image-right'
image: 'https://source.unsplash.com/collection/94734566/1920x1080'
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
# 2 Page
layout: 'image-right'
image: 'https://source.unsplash.com/collection/94734566/1920x1080'
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
# 3 Page
layout: 'image-right'
image: 'https://source.unsplash.com/collection/94734566/1920x1080'
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
# 4 Page
layout: 'image-right'
image: 'https://source.unsplash.com/collection/94734566/1920x1080'
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
# 5 Page
layout: 'default'
---
# target
꼬멘틀 이라고 하는 단어 맞추기 게임

## 살펴보기
1. 단어 입력하면 어떻게 될까?
2. 단어 전송 이후에 결과값은 어떨까? 

<div class="image03"></div>


---
# 6 Page
layout: 'default'
---
# 개발자도구 활용하기
`Network`탭에서 보면,  

<div class="image04"></div>


---
# 7 Page
layout: 'default'
---
# 개발자도구 활용하기
`Source`탭에서 보면,  

<div class="image05"></div>

---
# 7 Page
---
# [Spring Initializr](https://start.spring.io/)

<br><br>

추가할 dependencies 는,
### `Spring Reactive Web`
### `lombok`


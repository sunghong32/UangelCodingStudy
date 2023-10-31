//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/30.
//  백준 1316: 그룹 단어 체크
//  메모리: 79512 KB
//  시간: 12 ms

import Foundation

let N = Int(readLine()!)!
var answer = 0

(1...N).forEach { _ in
    if check() {
        answer += 1
    }
}

func check() -> Bool {
    let word = readLine()!
    var stack: [Character] = []
    word.forEach {
        if !stack.isEmpty && stack.last! == $0 {
            stack.removeLast()
        }
        stack.append($0)
    }
    return Set(stack).count == stack.count
}

print(answer)

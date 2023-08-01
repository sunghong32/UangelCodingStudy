//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/07/28.
// 백준 10799: 쇠막대기
// 메모리: 70660KB
// 시간: 24ms

let line = readLine()!.map{String($0)}
var stack = 0
var count = 0

for i in 0..<line.count {
    if line[i] == "(" {
        stack += 1
    } else {
        stack -= 1
        if line[i-1] == "(" {
            count += stack
        } else {
            count += 1
        }
    }
}

print(count)

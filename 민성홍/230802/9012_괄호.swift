//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/02.
// 백준 9012: 괄호
// 메모리: 79512KB
// 시간: 12ms

import Foundation

let T: Int = Int(readLine()!)!
var PS: Array = Array(repeating: [String](), count: T)

for i in 0..<T {
    PS[i] = readLine()!.map { String($0) }
}


func checkVPS(ps: [String]) -> String {
    var stack: Int = 0
    var result: String = ""

    for i in 0..<ps.count {
        if ps[i] == "(" {
            stack += 1
        } else {
            stack -= 1
        }

        if stack < 0 {
            break
        }
    }

    if stack == 0 {
        result = "YES"
    } else {
        result = "NO"
    }

    return result
}

for j in 0..<PS.count {
    print(checkVPS(ps: PS[j]))
}

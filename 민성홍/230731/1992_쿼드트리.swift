//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/01.
// 백준 1992: 쿼드트리
// 메모리: 79512KB
// 시간: 16ms

import Foundation

let N: Int = Int(readLine()!)!
var goyoungsang = Array(repeating: [String](), count: N)

for i in 0..<N {
    goyoungsang[i] = readLine()!.map { String($0) }
}

var result = ""

func check(i: Int, j: Int, size: Int) {
    var zeroCount: Int = 0
    var oneCount: Int = 0

    for x in i..<i + size {
        for y in j..<j + size {
            if goyoungsang[x][y] == "0" {
                zeroCount += 1
            } else {
                oneCount += 1
            }
        }
    }

    if zeroCount > 0 && oneCount > 0 {
        result += "("

        check(i: i, j: j, size: size / 2)
        check(i: i, j: j + size / 2, size: size / 2)
        check(i: i + size / 2, j: j, size: size / 2)
        check(i: i + size / 2, j: j + size / 2, size: size / 2)

        result += ")"
    } else {
        if zeroCount > oneCount {
            result += "0"
        } else {
            result += "1"
        }
    }
}

check(i: 0, j: 0, size: N)
print(result)

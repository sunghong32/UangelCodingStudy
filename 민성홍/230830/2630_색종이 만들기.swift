//
//  main.swift
//  BackjoonCodingTest
//
//  Created by 민성홍 on 2023/08/31.
//  백준 2630: 색종이 만들기
//  메모리: 69240KB
//  시간: 12ms

import Foundation

let N = Int(readLine()!)!
var paper: [[Int]] = []
for _ in 0..<N {
    paper.append(readLine()!.split(separator: " ").map { Int($0)! })
}

var whiteCount = 0
var blueCount = 0

func foldN(y: Int, x: Int, n: Int) {
    var white = 0
    var blue = 0
    for y in y..<y + n {
        for x in x..<x + n {
            if paper[y][x] == 0 {
                white += 1
            } else {
                blue += 1
            }
        }
    }

    if white == n * n {
        whiteCount += 1
        return
    }

    if blue == n * n {
        blueCount += 1
        return
    }
    foldN(y: y, x: x, n: n / 2)
    foldN(y: y, x: x + n / 2, n: n / 2)
    foldN(y: y + n / 2, x: x, n: n / 2)
    foldN(y: y + n / 2, x: x + n / 2, n: n / 2)
}

foldN(y: 0, x: 0, n: N)

print(whiteCount)
print(blueCount)

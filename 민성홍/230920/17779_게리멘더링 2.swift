//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/20.
//  백준 17779: 게리멘더링 2
//  메모리: 69108KB
//  시간: 108ms

import Foundation

typealias Point = (r: Int, c: Int)

let N: Int = Int(readLine()!)!
var A: [[Int]] = []
var min: Int = 40000

for _ in 0..<N {
    A.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}

func isInRange(
    _ p: Point,
    _ d1: Int,
    _ d2: Int
) -> Bool {
    return (0..<N ~= p.c + d1 && 0..<N ~= p.r - d1) &&
    (0..<N ~= p.c + d2 && 0..<N ~= p.r + d2) &&
    (0..<N ~= p.c + d1 + d2 && 0..<N ~= p.r - d1 + d2) &&
    0..<N ~= p.r + d2 - d1
}

func minDiff(
    _ p: Point,
    _ d1: Int,
    _ d2: Int
) -> Int {
    var population: [Int] = Array(repeating: 0, count: 5)

    for r in 0..<N {
        for c in 0..<N {
            if c <= p.c+d1, r < p.r, !(c > p.c && r >= p.r - (c-p.c)) {
                population[0] += A[r][c]
            } else if c > p.c+d1, r <= p.r-d1+d2, !(c <= p.c+d1+d2 && r >= p.r-d1 + (c-(p.c+d1))) {
                population[1] += A[r][c]
            } else if c < p.c+d2, r >= p.r, !(c >= p.c && r <= p.r + (c-p.c)) {
                population[2] += A[r][c]
            } else if c >= p.c+d2, r > p.r-d1+d2, !(c <= p.c+d1+d2 && r <= p.r-d1+d2 + ((p.c+d1+d2)-c)) {
                population[3] += A[r][c]
            } else {
                population[4] += A[r][c]
            }
        }
    }
    return population.max()! - population.min()!
}

for r in 1..<N {
    for c in 0..<N-1 {
        for d1 in 1...r {
            for d2 in 1...N-r {
                guard isInRange((r, c), d1, d2) else { break }
                let m = minDiff((r, c), d1, d2)
                if min > m {
                    min = m
                }
            }
        }
    }
}

print(min)

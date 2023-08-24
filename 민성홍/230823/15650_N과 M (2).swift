//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/24.
//  백준 15650: N과 M (2)
//  메모리: 79512KB
//  시간: 12ms

import Foundation

let NM = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = NM[0]
let M = NM[1]

var array: [Int] = []

recur(start: 1)

func recur(start: Int) {
    if array.count == M {
        print(array.map{ String($0) }.joined(separator:" "))
        return
    }

    for i in start..<(N + 1) {
        if !array.contains(i) {
            array.append(i)
            recur(start: i + 1)
            array.removeLast()
        }
    }
}

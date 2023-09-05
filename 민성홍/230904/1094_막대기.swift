//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/05.
//  백준 1094: 막대기
//  메모리: 79508KB
//  시간: 12ms

import Foundation

let X: Int = Int(readLine()!)!
var branchs: [Int] = [64]
var shortest: Int = 0

func cutBranch(length: Int) {
    if branchs.reduce(0, +) > X && branchs.last! > X {
        shortest = length / 2

        branchs.removeLast()
        branchs.append(shortest)

        cutBranch(length: shortest)
    } else {
        shortest = length / 2

        if shortest > 0 {
            branchs.append(shortest)
        }

        if branchs.reduce(0, +) > X {
            branchs.removeLast()

            cutBranch(length: shortest)
        } else if branchs.reduce(0, +) < X {
            cutBranch(length: shortest)
        } else {
            return
        }
    }
}

cutBranch(length: 64)

print(branchs.count)

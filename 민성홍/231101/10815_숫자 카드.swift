//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 11/1/23.
//  백준 10815: 숫자 카드
//  메모리: 128372 KB
//  시간: 548 ms

import Foundation

let N = Int(readLine()!)!
let nSet = Set(readLine()!.split(separator: " ").map { Int($0)! })
let M = Int(readLine()!)!
let mArray = readLine()!.split(separator: " ").map { Int($0)! }

let result = mArray.map { nSet.contains($0) ? "1" : "0" }.joined(separator: " ")

print(result)

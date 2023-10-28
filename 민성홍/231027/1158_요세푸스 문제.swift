//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/27.
//  백준 1158: 요세푸스 문제
//  메모리: 79792 KB
//  시간: 16 ms

import Foundation

let NK = readLine()!.split(separator: " ").map { Int($0)! }
var nums: [Int] = []
var index = NK[1] - 1
var answer: [Int] = []

for i in 1..<NK[0]+1 {
    nums.append(i)
}

while true {
    answer.append(nums.remove(at: index))
    if nums.isEmpty { break }
    index = (index + NK[1]-1) % nums.count
}


print("<" + answer.map({String($0)}).joined(separator: ", ") + ">")
